# teachHaeDuo
```
 주 제 : 학습중개사이트
 기획의도 : 우리나라의 교육열은 매우 치열하며 각자의 목표를 달성하기 위해 열심히 공부하는 학생들은 항상 존재하며, 
            다수의 학생들이 본인의 부족한 과목을 더 발전시키기 위해 따로 개인교습을 받곤 한다. 
            이는 곧 전문적인 선생님에게 가르침을 받고자 하는 열망으로 이어지며 나에게 맞는 선생님을 찾는 플랫폼이 필요하게 된다.  
            또한 과외를 하고싶은 선생님 역시 편하게 과외학생을 만날 수 있다. 
            그래서 우리는 선생님과 가르침을 원하는 학생을 중개해주는 전문적인 맞춤과목 과외중개 사이트를 개발하기로 하였다.
```

## 목차
[1. 개발환경](#개발환경)  
[2. 프로젝트 설계주안점](#프로젝트-설계주안점)  
[3. 구현 기능](#구현-기능)  
[4. 팀원 및 주 담당 기능](#팀원-및-주-담당-기능)
<!--[5. 스토리보드(pdf링크)] 
[6. 최종발표자료(pdf링크)]-->


## 개발환경
  + Servlet 4.0
  + JSP 3.1
  + Tomcat 9.0
  + Java 11.0.2
  + Eclipse Version: 2020-09 (4.17.0)
  + Github Desktop Version 2.9.14 (x64)
  + SQL Developer 버전 21.2.1.204 //Oracle 
  + HTML5
  + CSS


## 프로젝트 설계주안점
  + 다양한 카테고리 별 선생님 리스트 출력 가능
  + 선생님으로 등록 시 관리자 승인 후 활동 가능
  + 선생님과 학생간 쪽지 보내기 받기 기능
  + 찜하기 기능을 통해 원하는 선생님을 다시 찾는 불편함 해소
  + 선생님 및 게시글 신고 하기 기능을 통해 원치 않는 자료 구별 가능
  + 회원간 정보공유 및 소통을 위한 게시판
  + 사용자 입장이 아닌 관리자 입장에서 관리자 페이지 구현

## 구현 기능
  + 회원가입 및 로그인
  + 회원 정보 수정, 선생님 프로필 등록
  + 선생님 상세조회
  + 쪽지 보내기, 받기
  + 질문 게시판(CRUD + 댓글)
  + 선생님 찜하기
  + 신고하기(게시글, 선생님)
  + 관리자 페이지
    + 회원 강제탈퇴
    + 공지사항
    + 선생님 승인
    + 자주 묻는 질문 CRUD


## 팀원 및 주 담당 기능
+ **정민교**
  + 마이페이지(회원정보수정, 교습정보수정)
  + 마이페이지(찜내역, 쪽지내역, 포인트내역 조회)
  + 관리자 페이지(선생님  승인 기능)
  + 선생님 프로필 사진 등록,수정,삭제
  + 쪽지 기능
  
+ **김인곤**
  + 질문하기 게시판(CRUD + 댓글 기능+첨부파일)
  + 고객센터(자주 묻는 질문 CRUD)
  + 관리자페이지(신고글 리스트, 상세조회, 삭제)
  
+ **이소윤**
  + 메인 페이지 UI
  + 선생님 찾기(원하는 옵션으로 선생님 검색)
  + 선생님 상세조회
  + 선생님 찜하기, 신고하기, 연락하기, 리뷰
  
+ **이소윤**
  + 메인 페이지 UI
  + 선생님 찾기(원하는 옵션으로 선생님 검색)
  + 선생님 상세조회
  + 선생님 찜하기, 신고하기, 연락하기, 리뷰

+ **황선애**
  + 회원가입(정규식 유효성 체크, 이메일 인증, 주소 API)
  + 로그인
  + 아이디 찾기, 비밀번호 찾기 , 비밀번호 재설정 
  + 이용방법 (UI 화면 작성)
  + 관리자 페이지(회원 정보 조회)
  + 관리자 페이지 UI 화면 전체 작성

## 최종발표자료
