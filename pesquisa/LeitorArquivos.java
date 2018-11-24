package pesquisa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class LeitorArquivos {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long taxiID;
	private String data;
	private Double longitude;
	private Double latitude;
	
	public LeitorArquivos() {}

	public LeitorArquivos(Long taxiID, String data, Double longitude, Double latitude) {
		this.taxiID = taxiID;
		this.data = data;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public Long getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(Long taxiID) {
		this.taxiID = taxiID;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "LeitorArquivos [taxiID=" + taxiID + ", data=" + data + ", longitude=" + longitude + ", latitude="
				+ latitude + "]";
	}
	
	

}
