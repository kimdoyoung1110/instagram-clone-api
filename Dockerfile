# --- 1단계: 빵 굽기 (빌드 환경) ---
FROM eclipse-temurin:25-jdk-alpine AS builder
WORKDIR /app

# 그래들 파일과 소스 코드를 도커 박스 안으로 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 윈도우에서 작성된 gradlew 파일의 줄바꿈 오류 방지 및 실행 권한 부여
RUN sed -i 's/\r$//' gradlew
RUN chmod +x gradlew

# 도커 박스 안에서 직접 프로젝트를 빌드하여 jar 파일 생성! (테스트는 생략해서 속도업)
RUN ./gradlew clean build -x test


# --- 2단계: 포장 및 실행 (실행 환경) ---
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

# 1단계(builder)에서 방금 막 구워낸 jar 파일만 쏙 빼와서 app.jar로 이름 변경
COPY --from=builder /app/build/libs/*.jar app.jar

# 도커 박스를 켜면 자동으로 서버 실행!
ENTRYPOINT ["java", "-jar", "app.jar"]