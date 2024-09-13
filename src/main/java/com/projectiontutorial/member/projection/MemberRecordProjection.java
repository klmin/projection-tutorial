package com.projectiontutorial.member.projection;

public record MemberRecordProjection(
        Long memberId,
        String name,
        Long teamTeamId,
        String teamTeamName
) {

}

