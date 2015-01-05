package com.beci.internaltest;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Builder;

import java.util.List;

//@Data
//@RequiredArgsConstructor
//@ToString
@Setter
@Getter
//@Builder
public class TestLombok {
    private String name;
    private String gender;
    private String species;

    private boolean employed = true;
    private String name2;

    public TestLombok() {

    }

    //    @NonNull
//    private List<String> members;




//    @Cleanup ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //http://projectlombok.org/features/val.html
}
