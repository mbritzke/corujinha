package stub;

import com.github.mbritzke.entity.KeyWordEntity;

public class KeyWordEntityStub {

    public static KeyWordEntity createKeyWordEntity(){
        KeyWordEntity keyWordEntity = new KeyWordEntity();
        keyWordEntity.setId(1);
        keyWordEntity.setWord("word");
        return keyWordEntity;
    }

}
