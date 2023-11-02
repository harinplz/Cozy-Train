package com.ssafy.cozytrain.api.dto;

import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class FriendDto {

    @Getter
    @NoArgsConstructor
    public static class FriendReqDto{
        @ApiParam(value = "친구 ID 값")
        private Long memberId;

        @Builder
        public FriendReqDto(Long memberId) {
            this.memberId = memberId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class FriendAcceptReqDto{
        @ApiParam(value = "친구요청 PK 값")
        private Long friendId;

        @Builder
        public FriendAcceptReqDto(Long friendId) {
            this.friendId = friendId;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class FriendResDto{
        @ApiParam(value = "친구요청 PK 값")
        private Long friendId;
        private Long memberId;
        private String friendLoginId;
        private String friendNickname;
        private String profileImg;
        private LocalDateTime updatedAt;

        @Builder
        public FriendResDto(Long friendId, Long memberId, String friendLoginId, String friendNickname, String profileImg, LocalDateTime updatedAt) {
            this.friendId = friendId;
            this.memberId = memberId;
            this.friendLoginId = friendLoginId;
            this.friendNickname = friendNickname;
            this.profileImg = profileImg;
            this.updatedAt = updatedAt;
        }
    }
}
