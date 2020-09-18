package stub;

import com.github.mbritzke.entity.KeyWordEntity;

public class KeyWordEntityStub {

    public static KeyWordEntity creatKeyWordEntity(){
        KeyWordEntity keyWordEntity = new KeyWordEntity();
        keyWordEntity.setId(1);
        keyWordEntity.setWord("word");
        return keyWordEntity;
    }

}
