package com.mg.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author mg
 * @date 2024-10-06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Cattle {

    private String NickName;
    private Integer age;
    private String masterName;
    private WorkContent workContent;

}
