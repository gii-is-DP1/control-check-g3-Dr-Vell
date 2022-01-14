package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    private final RecoveryRoomService rrtService;

	@Autowired
	public RecoveryRoomTypeFormatter(RecoveryRoomService recoveryRoomService) {
		this.rrtService = recoveryRoomService;
    }
    
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.getName();
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        
		Collection<RecoveryRoomType> findRecoveryRoomTypes = this.rrtService.getAllRecoveryRoomTypes();
		for (RecoveryRoomType type : findRecoveryRoomTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
    }
    }
    

