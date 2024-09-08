package com.restapi.member.projection;


import lombok.Getter;

@Getter
public class MemberClassProjection

{
    Long memberId;
    String name;
    Long teamId;
    String teamName;

    public MemberClassProjection(Long memberId, String name, Long teamTeamId, String teamTeamName){
        this.memberId = memberId;
        this.name = name;
        this.teamId = teamTeamId;
        this.teamName = teamTeamName;
    }

}


