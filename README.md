# wanted-pre-onboarding-backend

**프리온보딩 백엔드 인턴십 선발과제**

<br><br>

## 요구사항 분석

참고 : 테이블명 { 필드명1 , 필드명2 ,... }

**채용공고**

* **엔티티**
  * Board { id(pk), position, reward, content, skill }
  * 채용공고 { id, 채용포지션, 채용보상금, 채용내용, 사용기술 }
* **비지니스**
  * 공고등록 함수
  * 공고수정 함수
  * 공고삭제 함수
  * 공고, 공고검색, 상세페이지 조회 함수

<br>

**채용신청**

* **엔티티**
  * BoardApply { id(pk), boardId, userId }
  * 채용신청 { id, 채용공고id , 사용자id }
* **비지니스**
  * 신청등록 함수
  * 유저신청 조회 함수

<br><br>

## 구현과정

**요구사항 분석 후 아래 순서로 구현**

**엔티티(도메인) -> 레퍼지토리 -> 서비스 -> 서비스 테스트코드 작성 -> API(컨트롤러) 구현**

<br>

**포스트 맨을 통해 API 테스트**

![image](https://github.com/BH946/wanted-pre-onboarding-backend/assets/80165014/20603b73-13d6-4c11-9bac-f9b351ac39ab) 

