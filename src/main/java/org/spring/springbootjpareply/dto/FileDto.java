package org.spring.springbootjpareply.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootjpareply.entity.BoardEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class FileDto {


    private Long id;
    private LocalDateTime createTime;
    private String oldFileName; //원래이름
    private String newFileName; //db저장이름
    private BoardEntity fileFK;
    private LocalDateTime updateTime;

}
