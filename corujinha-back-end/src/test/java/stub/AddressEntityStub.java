package stub;

import com.github.mbritzke.entity.AddressEntity;

import java.util.Collections;
import java.util.List;

public class AddressEntityStub {

    public static AddressEntity createAddressEntity(){
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(1);
        addressEntity.setName("42");
        addressEntity.setUrl("www.42.com.br");
        addressEntity.setLanguage("Portuguese");
        addressEntity.setKeyWordId(1);
        return addressEntity;
    }
    
    public static List<AddressEntity> createListOfAddressEntity(){
        return Collections.singletonList(createAddressEntity());
    }
}
