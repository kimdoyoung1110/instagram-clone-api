# 📸 Instagram Clone API (Core Version)

복잡한 외부 연동(AWS S3, Redis, Security 등)을 걷어내고, 인스타그램의 핵심 비즈니스 로직과 도메인(회원, 게시글, 댓글, 좋아요)에 집중하여 구현한 RESTful API 서버입니다.

## 🛠 Tech Stack
- **Language:** Java 17
- **Framework:** Spring Boot
- **Database:** Spring Data JPA, H2 / MySQL
- **Build Tool:** Gradle

## 📁 Domain Structure
핵심 도메인별로 패키지를 분리하여 응집도를 높였습니다.
- `member`: 사용자 가입 및 회원 관리
- `post`: 게시글(사진/글) 생성, 수정, 단건/다건 조회, 삭제
- `comment`: 게시글 내 댓글 생성 및 조회
- `like`: 게시글 좋아요 및 취소 기능

## 🚀 Getting Started
```bash
$git clone [https://github.com/kimdoyoung1110/instagram-clone-api.git$](https://github.com/kimdoyoung1110/instagram-clone-api.git$) cd instagram-clone-api
$./gradlew build$ ./gradlew bootRun