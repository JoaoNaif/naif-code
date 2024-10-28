package br.com.joaonaif.naif_code.modules.task.dto;

import br.com.joaonaif.naif_code.modules.task.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutTaskRequestDTO {

    private String name;
    private Category category;
}
