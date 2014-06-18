package bowling;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class ShootConvector {

	private String inputFrameString;
	
	public ShootConvector(String inputFrameString) {
		this.inputFrameString = inputFrameString;
	}
	
	public List<Shoot> convert() {
		List<Shoot> frame = new ArrayList<Shoot>();
		
		for(char c : inputFrameString.toCharArray()) {
			switch (c) {
			case 'X':
				frame.add(new Shoot(10, Type.STRIKE));
				break;
			case '/':
				frame.add(new Shoot(10, Type.SPARE));
				break;
			case '-':
				frame.add(new Shoot(0, Type.NORMAL));
				break;
			default:
				if (Character.isDigit(c)) {
					frame.add(new Shoot(Character.getNumericValue(c), Type.NORMAL));
				} else {
					throw new InvalidParameterException();
				}
			}
		}
		
		return frame;
	}
}
