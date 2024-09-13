package com.projectiontutorial.team.projection;

public record TeamRecordProjection(
    Long teamId,
    String teamName,
    Long membersMemberId,
    String membersName

) {
}
