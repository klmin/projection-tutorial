package com.restapi.team.projection;

import java.util.List;

public interface TeamInterfaceProjection {
    Long getTeamId();
    String getTeamName();
    Integer getTeamNum();
    List<MemberProjection> getMembers();

    interface MemberProjection{
        Long getMemberId();
        String getName();
        Integer getAge();

    }
}
