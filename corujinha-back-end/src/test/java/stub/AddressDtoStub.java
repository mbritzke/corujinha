package stub;

import com.github.mbritzke.dto.AddressDto;

import java.util.Collections;
import java.util.List;

public class AddressDtoStub {

    public static AddressDto createAddressDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(1);
        addressDto.setName("42");
        addressDto.setUrl("www.42.com.br");
        addressDto.setLanguage("Portuguese");
        return addressDto;
    }

    public static List<AddressDto> createListOfAddresDto() {
        return Collections.singletonList(createAddressDto());
    }
}
