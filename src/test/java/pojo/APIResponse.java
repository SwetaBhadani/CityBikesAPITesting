package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author swetabhadani
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {

	private List<Network> networks;

	public List<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(List<Network> networks) {
		this.networks = networks;
	}
}
