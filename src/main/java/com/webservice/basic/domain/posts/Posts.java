package com.webservice.basic.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter// 클래스 내 모든 필드의 Getter 메소드를 자동으로 생성
@NoArgsConstructor // 기본 생성자 자동 추가 / public posts(){}와 같은 효과
@Entity// 테이블과 링크될 클래스임을 나타낸다. 테이블 이름은 클래스의 카멜케이스 이름
public class Posts {

    @Id // 해당 테이블의 pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성 규칙 , IDENTITY는 AUTO_INCREMENT를 위함
    private Long id;

    @Column(length = 500,nullable = false) // 테이블의 칼럼, 굳이 선언하지 않아도 됨 -- 기본 값 이외에 추가로 변경이 필요한 옵션 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update (String title, String content ){
        this.title = title;
        this.content = content;

    }
}
