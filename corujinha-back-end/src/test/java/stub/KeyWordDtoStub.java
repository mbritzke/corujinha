package stub;

import com.github.mbritzke.dto.KeyWordDto;

public class KeyWordDtoStub {

    public static KeyWordDto createKeyWordDto() {
        KeyWordDto keyWordDto = new KeyWordDto();
        keyWordDto.setId(1);
        keyWordDto.setWord("word");
        return keyWordDto;
    }

}
