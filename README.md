# 📸 Instagram Clone API (Core Version)

기존 인스타그램 클론 프로젝트에서 복잡한 외부 인프라 연동(S3, Redis, Spring Security 등)을 걷어내고, 서비스의 가장 본질적인 핵심 도메인(User, Post, Comment 등)만 독립적으로 분리하여 7일 완성 로드맵으로 구현 중인 백엔드 REST API 프로젝트입니다.

## 📌 프로젝트 배경 및 참고 자료
* **오리지널 레포지토리:** [Spring_instagram-clone](https://github.com/Instagram-Clone-Coding/Spring_instagram-clone.git)
* **API 명세서:** [인스타그램 핵심 API 기획 및 명세서](https://stealth-ghoul-4fd.notion.site/api-3120fa3de3eb804da9a1ffdff3df4ec6?pvs=74)

## 🛠️ Tech Stack
* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Database:** H2 Database (In-Memory) -> *배포 단계에서 PostgreSQL로 마이그레이션 예정*
* **ORM:** Spring Data JPA
* **Tool:** Gradle, Lombok, Postman

## 🚀 현재 구현된 기능 (진행 중)
현재 7일 단기 완성 로드맵 중 **3일 차 핵심 CRUD**까지 완료되었습니다.

### 👤 User (유저)
* `POST /api/members` : 유저 생성 (회원가입)

### 📝 Post (게시물 피드)
* `POST /api/posts` : 게시물 작성
* `GET /api/posts` : 전체 게시물 피드 조회
* `PUT /api/posts/{postId}` : 게시물 수정
* `DELETE /api/posts/{postId}` : 게시물 삭제

## 📅 앞으로의 로드맵 (4일 차 ~ 7일 차)
- [ ] **Day 4:** 부가 기능 추가 (댓글 작성 및 좋아요 기능 연관관계 매핑)
- [ ] **Day 5:** GitHub Actions를 활용한 CI (자동 빌드 및 테스트 파이프라인) 구축
- [ ] **Day 6:** 클라우드 환경 배포 (Render/Railway) 및 외부 DB 연결
- [ ] **Day 7:** 라이브 환경 운영 테스트 및 모니터링 환경 점검

## 💻 로컬 환경 실행 방법 (How to Run)
1. 이 레포지토리를 로컬 환경에 클론
```bash
   git clone [https://github.com/kimdoyoung1110/instagram-clone-api.git](https://github.com/kimdoyoung1110/instagram-clone-api.git)
```
2. 프로젝트 최상단 디렉토리로 이동하여 애플리케이션을 빌드 및 실행합니다.
```bash
   ./gradlew bootRun
```
3. 서버가 8080 포트에서 실행됩니다. 내장 H2 데이터베이스 콘솔은 http://localhost:8080/h2-console에서 접속 가능합니다.
- JDBC URL: jdbc:h2:mem:testdb 
- Username: sa
- Password: (공란)
   
## 👨‍💻 Author
### 김도영 (Kim Do-young)
- GitHub: @kimdoyoung1110
- Email: from.dozero@gmail.com