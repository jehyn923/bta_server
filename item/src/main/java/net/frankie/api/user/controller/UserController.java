package net.frankie.api.user.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import net.frankie.api.user.domain.User;
import net.frankie.api.user.domain.UserDto;
import net.frankie.api.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//웹 프론트, 백이 나눠져 있어 요청을 받을 때 CORS 처리 해주지 않으면 막힘
@CrossOrigin (origins = "*", allowedHeaders = "*")
@Api(tags = "users")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
//웹단과 맞닿아 있는 부분이라, 보안에 신경써야할 부분
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    //ResponseEntity는 보안을 위해 추가적인 래핑을 해주는 것이라 생각하면 된다.
    //항상 보안적인 부분에서 신경쓰는 코드
    @ApiOperation(value="${UserController.signup}")
    @ApiResponses(value={
            @ApiResponse(code=400,message = "Something Wrong"),
            @ApiResponse(code=403,message = "승인거절"),
            @ApiResponse(code=422,message = "중복된 ID")
    })
    public ResponseEntity<String> signup(@ApiParam("Signup User")
                                             @RequestBody UserDto userDto){
        System.out.println("회원가입 정보 : " + userDto.toString());
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }
    @PostMapping("/signin")
    @ApiOperation(value="${UserController.signin}")
    @ApiResponses(value={
            @ApiResponse(code=400,message = "Something Wrong"),
            @ApiResponse(code=422,message = "유효하지 않는 아이디 / 비밀번호")
    })
    public ResponseEntity<UserDto> signin(@ApiParam("Signup User")
                                             @RequestBody UserDto userDto){
        System.out.println("로그인 정보 : " + userDto.toString());
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }

}
