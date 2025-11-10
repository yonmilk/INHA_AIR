> 인하공업 전문대학 컴퓨터시스템과 2학년 1학기 [Java 프로그래밍 응용] 과제 팀 프로젝트입니다.\
> 원본은 [INHA_AIR_TEAM](https://github.com/yonmilk/INHA_AIR_TEAM.git)에서 확인 가능합니다.

항공 예매 시스템에서 항공 예매 기능을 주로 구현했습니다.

# INHA_AIR: 항공 예매 시스템

## 프로젝트 개요
**기간**: 2021.05.13 ~ 2021.06.15 (약 1개월)

### 목표
#### 사용자
  - 간편한 항공 스케줄 조회
  - 직관적인 UI로 탑승일 선택 지원
  - 빠르고 편리한 항공권 예약/발권 시스템
#### 관리자
  - 항공편 스케줄 관리
  - 예약 현황 조회 및 관리

### 팀원 및 역할
이름 | github | 역할
----|--------|------
김연우 | [@yonmilk](https://github.com/yonmilk) | 항공권 예매(예매정보입력) 및 로그인, 회원가입, 아이디/비밀번호 찾기 UI 개발 및 구현
김민주 | [@MinJu-A](https://github.com/MinJu-A) | 데이터베이스 및 관리자 메뉴 UI 개발 및 구현
노예원 | [@yewon-Noh](https://github.com/yewon-Noh) | 데이터베이스 및 항공권 예매(탑승정보입력, 결제) 관련 UI 개발 및 구현
민보현 | [@bhmin45](https://github.com/bhmin45) | 프로젝트 기획, 항공 스케줄 조회 및 항공권 예매(좌석선택) 관련 UI 개발 및 구현

### 사용 도구
- **언어**: Java
- **GUI**: Java Swing
- **데이터베이스**: MySQL, SQLite
- **개발 도구**: Git, Discord

### 담당 업무 주요 내용

- 사용자 세션 유지를 위한 전역 변수 관리
- **정규 표현식**으로 입력값 검증 분기 처리(로그인, 회원가입 등)
- 아이디/비밀번호 찾기 등 예외 상황 대응 UI 구성
- 출발지와 도착지 선택을 위해 항공 스케줄을 테이블로 표시하는 UI 구현
- 탑승일 선택을 위한 달력 UI 개발 (마우스클릭/키보드로 날짜 입력 가능)
- 탑승 인원 수 선택 UI 구현 및 나이 계산기(성인/소아/유아 구분)


<br>

# 프로젝트 결과 및 자료

<img src="https://github.com/user-attachments/assets/ac704783-e1f2-4070-b46c-5af008a3f2b8" width="100%">

<table>
<tr>
  <td width="33%"><img alt="00_start" src="https://github.com/user-attachments/assets/8d25ba5e-fd9b-4b41-a871-f6a1465601cb" /></td>
  <td width="33%"><img alt="01_idpw" src="https://github.com/user-attachments/assets/2fe7278e-5e35-4c3b-aa19-1b9451bd6f11" /></td>
  <td width="33%"><img alt="01_signin" src="https://github.com/user-attachments/assets/3d2c226d-c833-46cc-b33b-eac3209f9eec" /></td>
</tr>
<tr>
  <td><img alt="01_signup_1" src="https://github.com/user-attachments/assets/48fb7544-0f25-4b42-976c-3497ba9070c2" /></td>
  <td><img alt="02_menu" src="https://github.com/user-attachments/assets/d4a5bf4e-fca3-4284-a2d1-0501782eeb6b" /></td>
  <td><img alt="03_search_1" src="https://github.com/user-attachments/assets/4fa8ce57-c3e0-43e5-9dee-291737aacc27" /></td>
</tr>
<tr>
  <td><img alt="04_book_00" src="https://github.com/user-attachments/assets/5865e186-b488-4317-ac13-84cfd0eb682b" /></td>
  <td><img alt="04_book_01" src="https://github.com/user-attachments/assets/4f024dbd-2f6e-46f4-bd31-9163ff649130" /></td>
  <td><img alt="04_book_02" src="https://github.com/user-attachments/assets/15acb567-7c9e-401d-8d6d-198f0b6ea313" /></td>
</tr>
<tr>
  <td><img alt="04_book_03" src="https://github.com/user-attachments/assets/2e3e205c-7b23-4f31-9cd0-62be51380c33" /></td>
  <td><img alt="04_book_04" src="https://github.com/user-attachments/assets/29aa911d-a0f4-4316-a7bb-8d71511d3baf" /></td>
  <td><img alt="04_book_06" src="https://github.com/user-attachments/assets/6b9f2f89-a237-4cc1-9293-2fe1bf19ce6c" /></td>
</tr>
<tr>
  <td><img alt="04_book_07" src="https://github.com/user-attachments/assets/65ae08da-a1f9-4e8a-a766-7cb20985cf70" /></td>
  <td><img alt="04_book_08" src="https://github.com/user-attachments/assets/c8edc703-c17e-4b1e-b196-70ec9d706932" /></td>
  <td><img alt="04_book_09" src="https://github.com/user-attachments/assets/b537accb-6148-4e6a-8286-d91f7d512350" /></td>
</tr>
<tr>
  <td><img alt="04_book_10" src="https://github.com/user-attachments/assets/8f07ccca-aab9-4291-bfa1-4d9ee1659b48" /></td>
  <td><img alt="04_book_11" src="https://github.com/user-attachments/assets/f0e82257-9ecf-41d7-8fa3-0b74500cbf38" /></td>
  <td><img alt="04_book_12" src="https://github.com/user-attachments/assets/5b6f7cb4-cf37-4436-8102-8a9b06fefd30" /></td>
</tr>
<tr>
  <td><img alt="05_detail_0" src="https://github.com/user-attachments/assets/21364126-fbfb-47fc-bdec-a8e39f0d993f" /></td>
  <td><img alt="05_detail_1" src="https://github.com/user-attachments/assets/3da38672-ce72-41c8-acdc-e0e6a33404d4" /></td>
  <td><img alt="06_management" src="https://github.com/user-attachments/assets/adc3b157-c14a-4236-9ec9-77c787584b66" /></td>
</tr>
</table>

## 구조도

<table>
<tr>
  <td width="50%"><sub>사용자 페이지 구조</sub><br><img alt="information_architecture_admin" src="https://github.com/user-attachments/assets/7f27ce80-0fe5-4f92-bda8-71eeb63719a5" /></td>
  <td width="50%"><sub>관리자 페이지 구조</sub><br><img alt="information_architecture_user" src="https://github.com/user-attachments/assets/36d630ce-7c55-41ce-8b61-94b5993bbbbb" /></td>
</tr>
</table>

## 순서도

<table>
<tr>
  <td width="33%"><img alt="flow_U01_signin" src="https://github.com/user-attachments/assets/e32932b6-cec6-4410-9136-3641a330b8a1" /></td>
  <td width="33%"><img alt="flow_U02_signup" src="https://github.com/user-attachments/assets/34a613ec-fc44-4c03-b026-0a79baaa995d" /></td>
  <td width="33%"><img alt="flow_U03_book_0" src="https://github.com/user-attachments/assets/f03169ce-183d-45d2-9623-827578af2797" /></td>
</tr>
<tr>
  <td><img alt="flow_U03_book_1" src="https://github.com/user-attachments/assets/df65bd0a-80a7-4db1-91e2-9044f92a0a7e" /></td>
  <td><img alt="flow_U03_book_2" src="https://github.com/user-attachments/assets/c29e168c-35d8-46ce-83fa-11533ea4b9eb" /></td>
  <td><img alt="flow_U04_book_info_0" src="https://github.com/user-attachments/assets/c6415db6-39c8-44bd-a9d7-dea6d8055828" /></td>
</tr>
<tr>
  <td><img alt="flow_U04_book_info_1" src="https://github.com/user-attachments/assets/331d27d7-6746-4f99-80dd-16176c8517c8" /></td>
  <td><img alt="flow_U04_book_info_2" src="https://github.com/user-attachments/assets/f9283639-be69-442e-83fb-3fb3bfabe2ce" /></td>
  <td><img alt="flow_U05_detail_0" src="https://github.com/user-attachments/assets/8d1f2efb-2571-42ab-b7bc-3e838bff0bd5" /></td>
</tr>
<tr>
  <td><img alt="flow_U05_detail_1" src="https://github.com/user-attachments/assets/43846314-5cf2-4940-9751-49f0efdef398" /></td>
  <td><img alt="flow_A06_admin_0" src="https://github.com/user-attachments/assets/0cbce240-08be-4bbd-b019-9bc4d7b3a1fe" /></td>
</tr>
</table>

## 데이터베이스

**데이터베이스 테이블 정보**

| 테이블명 | 설명 |
| --- | --- |
| airport | 공항정보 |
| airplane | 항공기 편명 |
| airSchedule | 항공 스케줄 |
| seat | 항공 스케줄 별 잔여 좌석 |
| user | 회원 정보 |
| reservation | 예매 내역 |
| reservationDetail | 예매 상세 내역 |
| payment | 결제 |
| login | 로그인 정보 |

  <img alt="databases_1" src="https://github.com/user-attachments/assets/70668a44-f117-4198-b88a-acd03750c90f" />
  <img alt="databases_2" src="https://github.com/user-attachments/assets/93759053-23e8-4601-98dc-c865f09ba2b1" />

