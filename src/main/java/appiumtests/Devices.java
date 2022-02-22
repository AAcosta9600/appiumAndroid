package appiumtests;

import java.util.List;

public class Devices {
	private List<Device> devices;

	public Devices(List<Device> devices) {
		super();
		this.devices = devices;
	}

	public Devices() {
		super();
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	@Override
	public String toString() {
		return "Devices [devices=" + devices + "]";
	}
	
	

}
