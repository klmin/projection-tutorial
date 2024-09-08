package com.restapi.team.projection;

import java.util.List;

public record TeamRecordProjection(
    Long teamId,
    String teamName,
    Integer teamNum,
    Long membersMemberId,
    String membersName,
    Integer membersAge

) {
}
