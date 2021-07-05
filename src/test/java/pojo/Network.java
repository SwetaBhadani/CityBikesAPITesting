package pojo;

import java.util.List;

/**
 * 
 * @author swetabhadani
 *
 */
public class Network {

	List<String> company;
	String gbfs_href;
	String href;
	String id;
	Location location;
	String name;
	String source;
	License license;

	public String getGbfs_href() {
		return gbfs_href;
	}

	public void setGbfs_href(String gbfs_href) {
		this.gbfs_href = gbfs_href;
	}

	

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<String> getCompany() {
		return company;
	}

	public void setCompany(List<String> company) {
		this.company = company;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
