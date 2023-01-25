package org.spring.springbootjpareply.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.springbootjpareply.dto.FileDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "jpa_file_tb")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateTime;


    @Column(nullable = false)
    private String oldFileName; //원래이름

    @Column(nullable = false)
    private String newFileName; //db저장이름

            //fetch =FetchType.LAZY 적용되는 시점 (선언하지 않아도 default)
    @ManyToOne( fetch =FetchType.LAZY )
    @JoinColumn(name = "board_id") //board table PK컬럼명
    private BoardEntity fileFK;


    public static FileEntity toFileEntity(BoardEntity boardEntity3, String originalFilename, String newFileName) {
    FileEntity fileEntity = new FileEntity();

    fileEntity.setFileFK(boardEntity3);
    fileEntity.setOldFileName(originalFilename);
    fileEntity.setNewFileName(newFileName);

    return fileEntity;
    }

}
