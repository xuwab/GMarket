package com.example.wab.gmarket.http.request;

import com.example.wab.gmarket.http.data.UserInfo;
import com.example.wab.gmarket.http.response.GroupMemberList;
import com.example.wab.gmarket.http.response.Response;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * @description: 观众列表请求
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class FetchGroupMemberListReuest extends IRequest {

    public FetchGroupMemberListReuest(int requestId, String userId, String groupId, String liveId,
                                      String hostId, int pageIndex, int pageSize) {
        mRequestId = requestId;
        mParams.put("action", "groupMember");
        mParams.put("userId", userId);
        mParams.put("groupId", groupId);
        mParams.put("liveId", liveId);
        mParams.put("hostId", hostId);
        mParams.put("pageIndex", pageIndex);
        mParams.put("pageSize", pageSize);
    }

    @Override
    public String getUrl() {
        return getHost() + "Live";
    }

    @Override
    public Type getParserType() {
        return new TypeToken<Response<GroupMemberList<UserInfo>>>() {
        }.getType();
    }
}
