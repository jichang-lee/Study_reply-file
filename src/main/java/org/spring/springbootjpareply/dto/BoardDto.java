package org.spring.springbootjpareply.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootjpareply.entity.BoardEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class BoardDto {

  public Long id;  //글번호

    @NotEmpty(message = "제목을 입력하세요")
    @NotBlank(message = "null")
    @NonNull //공백과 null를 허용하지 않는다
  private String title;//글제목

    @NotEmpty(message = "내용을 입력하세요")
    @Size(min = 5,max = 255) //내용 입력시 최소5, 최대255
  private String content;//글내용

    @NotEmpty(message = "작성자를 입력하세요")
  private String writer;//글작성자

  private int hit; // 조회수

    @NotEmpty(message = "게시글 암호를 입력하세요")
  private String boardPw;  //글비빌번호 -> 글삭제 시 사용 할 수 있다.

  private LocalDateTime createTime; // 처음 글작성 시간1

  private LocalDateTime updateTime;// 글 수정 시간



    //파일 업로드 파일을 저장할 수 있는 객체
    private MultipartFile boardFile;

    //파일이 있을 경우
    private String oldFileName;
    private String newFileName;
    private int attachFile;

  // Entity -> Dto    글목록 , 글상세내역
  public static BoardDto toBoardDtoDo(BoardEntity boardEntity){
        BoardDto boardDto=new BoardDto();// @NoArgsConstructor
        boardDto.setId(boardEntity.getId());
        boardDto.setTitle(boardEntity.getTitle());
        boardDto.setContent(boardEntity.getContent());
        boardDto.setWriter(boardEntity.getWriter());
        boardDto.setHit(boardEntity.getHit());
        boardDto.setBoardPw(boardEntity.getBoardPw());
        boardDto.setCreateTime(boardEntity.getCreateTime());
        boardDto.setUpdateTime(boardEntity.getUpdateTime());

        if(boardEntity.getAttachFile()==0){
            boardDto.setAttachFile(boardEntity.getAttachFile()); //파일이 없을 경우
        }else{
            boardDto.setAttachFile(boardEntity.getAttachFile()); //파일이 있으면
            //원래 파일 이름 가져온다 -> 파일의 원래이름 가져오는 방법
            boardDto.setOldFileName(boardEntity.getFileEntities().get(0).getOldFileName());
            //새 파일이름(DB저장이름) 가져온다 . -> 파일의 새 파일이름 가져오는 방법
            boardDto.setNewFileName(boardEntity.getFileEntities().get(0).getNewFileName());
        }


        return boardDto;
  }





}
