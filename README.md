# Spring Playground

Spring Framework와 Spring Boot의 핵심 개념을 학습하고 직접 구현한
프로젝트를 모아둔 저장소입니다.\
단순 기능 구현뿐 아니라 계층 분리, 데이터 접근 방식, 의존관계 관리,
인증/인가, 테스트 코드 작성 등 백엔드 개발의 기본 구조를 익히는 데
초점을 두었습니다.

------------------------------------------------------------------------

## Project 1. Shop

상품, 회원, 게시글, 댓글, 판매 기능을 구현하며 Spring Boot 기반 웹
애플리케이션의 전체적인 흐름을 학습한 프로젝트입니다.

### Tech Stack

-   Java
-   Spring Boot
-   Spring MVC
-   Spring Data JPA
-   Spring Security
-   Thymeleaf
-   MySQL
-   Gradle
-   HTML / CSS

### 주요 구현 내용

-   상품(Item) 등록 및 조회 등 상품 관리 기능
-   회원(Member) 관련 기능 및 Service 계층 구성
-   Spring Security를 활용한 인증/인가 구성
-   게시글(Post) 기능 구현
-   댓글(Comment) 기능 구현
-   판매(Sales) 도메인 구성
-   JPA Repository를 통한 데이터 접근
-   Controller / Service / Repository 계층 분리
-   Thymeleaf 기반 서버 사이드 화면 구성
-   공통 예외 처리를 위한 `MyExceptionHandler` 구성

### Project Structure

``` text
com.jooyeon.shop
├── comment
│   ├── Comment
│   ├── CommentController
│   └── CommentRepository
├── item
│   ├── Item
│   ├── ItemController
│   ├── ItemRepository
│   └── ItemService
├── member
│   ├── Member
│   ├── MemberController
│   ├── MemberRepository
│   └── MemberService
├── post
│   ├── Post
│   ├── PostController
│   └── PostRepository
├── sales
├── BasicController
├── MyExceptionHandler
├── SecurityConfig
└── ShopApplication
```

``` text
resources
├── static
│   ├── index.html
│   └── main.css
└── templates
    ├── detail.html
    ├── error.html
    ├── join.html
    ├── list.html
    ├── login.html
    ├── modify.html
    ├── mypage.html
    ├── nav.html
    ├── post.html
    └── write.html
```

### 학습 포인트

Spring MVC의 요청 처리 흐름을 기반으로 Controller, Service, Repository의
역할을 분리하고, JPA를 이용해 객체와 데이터베이스를 연동했습니다. 또한
Spring Security를 적용해 인증/인가 흐름을 경험하고,
게시글·댓글·회원·상품 등 여러 도메인을 하나의 웹 애플리케이션 안에서
구성했습니다.

------------------------------------------------------------------------

## Project 2. Board / Spring Basic

Spring의 핵심 원리와 다양한 데이터 접근 방식을 학습하기 위해 만든
프로젝트입니다.\
현재 패키지 구조는 `hello_spring`을 기준으로 구성되어 있으며, 회원
도메인을 중심으로 Spring MVC, DI, AOP, JDBC, JPA, Spring Data JPA를
단계적으로 적용했습니다.

### Tech Stack

-   Java
-   Spring Boot
-   Spring MVC
-   Spring JDBC / JdbcTemplate
-   JPA
-   Spring Data JPA
-   H2 Database
-   Gradle
-   JUnit
-   Thymeleaf

### 주요 구현 내용

-   회원(Member) 도메인 및 회원 서비스 구현
-   Controller / Service / Repository 계층 분리
-   메모리 기반 Repository 구현
-   순수 JDBC 기반 Repository 구현
-   `JdbcTemplate` 기반 Repository 구현
-   JPA 기반 Repository 구현
-   Spring Data JPA 기반 Repository 구현
-   `SpringConfig`를 통한 Bean 등록 및 의존관계 설정
-   AOP를 활용한 메서드 실행 시간 측정
-   Thymeleaf 기반 화면 구성
-   Repository 및 Service 계층 테스트 코드 작성

### Project Structure

``` text
jooyeon.hello_spring
├── aop
│   └── TimeTraceAop
├── controller
│   ├── HelloController
│   ├── HomeController
│   ├── MemberController
│   └── MemberForm
├── domain
│   └── Member
├── repository
│   ├── JdbcMemberRepository
│   ├── JDBCTemplateMemberRepository
│   ├── JpaMemberRepository
│   ├── MemberRepository
│   ├── MemoryMemberRepository
│   └── SpringDataJpaMemberRepository
├── service
│   └── MemberService
├── HelloSpringApplication
└── SpringConfig
```

``` text
test
└── jooyeon.hello_spring
    ├── repository
    ├── service
    └── HelloSpringApplicationTests
```

### 테스트

Repository와 Service 계층에 대한 테스트 코드를 작성해 기능을
검증했습니다. 애플리케이션을 직접 실행해 화면에서만 확인하는 방식이
아니라, 각 계층의 동작을 테스트 코드로 검증하는 방식을 학습했습니다.

특히 동일한 `MemberRepository` 역할을 메모리, JDBC, JdbcTemplate, JPA,
Spring Data JPA 방식으로 각각 구현하면서 데이터 접근 기술이 변경되어도
상위 계층의 역할을 최대한 유지할 수 있도록 인터페이스 기반 구조를
학습했습니다.

### 학습 포인트

Spring Bean과 의존관계 주입(DI)의 기본 원리를 익히고, 데이터 접근 기술을
`Memory → JDBC → JdbcTemplate → JPA → Spring Data JPA` 순서로 확장하며
각 방식의 차이를 학습했습니다. 또한 AOP를 적용해 공통 관심사를 핵심
비즈니스 로직과 분리하고, 테스트 코드를 통해 Repository와 Service의
동작을 검증했습니다.

------------------------------------------------------------------------

## Project 3. Java Core

Spring의 의존관계 주입을 이해하기 위해 회원·주문·할인 도메인을 순수 Java로 구현한 프로젝트입니다.

### Tech Stack

- Java 21
- Gradle
- JUnit

### 주요 구현 내용

- 회원 저장소와 회원 서비스, 주문 서비스를 인터페이스와 구현체로 분리
- VIP 회원 대상 정액 할인 및 10% 정률 할인 정책 구현
- `AppConfig`에서 구현체를 생성하고 생성자로 주입해 의존관계 구성
- 회원 가입, 주문 생성, 할인 정책을 검증하는 테스트 작성

### 학습 포인트

서비스가 구체적인 저장소·할인 정책을 직접 생성하지 않도록 구성하고, `AppConfig`에서 의존관계를 연결했습니다. 할인 정책의 구현을 바꿀 때 주문 서비스 코드를 수정하지 않는 구조를 학습했습니다.

------------------------------------------------------------------------

## Project 4. Java to Spring

Project 3의 회원·주문 예제를 Spring 컨테이너 기반으로 옮기고, 빈 조회·생명주기·스코프를 학습한 프로젝트입니다.

### Tech Stack

- Java 21
- Spring Boot
- Spring Context / Spring MVC
- Gradle
- JUnit
- Lombok

### 주요 구현 내용

- `AppConfig`에 `@Configuration`, `@Bean`을 적용해 회원·주문·할인 구성 요소를 Spring 빈으로 등록
- `ApplicationContext`를 통한 빈 조회와 `BeanDefinition` 확인 테스트 작성
- 초기화·종료 콜백을 이용한 빈 생명주기 테스트 작성
- 요청 범위의 `MyLogger`를 프록시로 주입하는 Controller·Service 예제 구현

### 학습 포인트

순수 Java의 수동 의존관계 구성에서 Spring 컨테이너의 빈 관리로 전환하는 과정을 비교했습니다. 빈 설정 정보, 조회 방식, 생명주기와 웹 요청 범위 빈의 주입 방식을 코드와 테스트로 확인했습니다.

------------------------------------------------------------------------

## Repository Structure

``` text
spring-playground
├── project1-shop
│   └── Spring Boot 쇼핑몰 학습 프로젝트
├── project2-spring-basic
│   └── Spring 기본 원리 및 데이터 접근/테스트 학습 프로젝트
├── project3-java
│   └── 순수 Java 회원·주문·할인 및 의존관계 구성 학습 프로젝트
└── project4-java-to-spring
    └── Spring 빈·생명주기·스코프 학습 프로젝트
```

> 이 저장소는 Spring 백엔드 개발 역량을 단계적으로 학습하고 구현한
> 내용을 기록하기 위한 프로젝트 모음입니다.
