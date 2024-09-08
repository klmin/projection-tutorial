package com.restapi.member.entity;


import com.restapi.team.entity.Team;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor
@SequenceGenerator(name="MEMBER_SEQ_GENERATOR", sequenceName="MEMBER_SEQ", initialValue=1, allocationSize=50)
public class Member {

    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator="MEMBER_SEQ_GENERATOR")
    private Long memberId;

    @Column(length = 30)
    private String name;

    @Column
    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="teamId")
    private Team team;

}
