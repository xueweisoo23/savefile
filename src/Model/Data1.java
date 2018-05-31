package Model;

import java.util.jar.Attributes.Name;

public class Data1 {
	private String Name ;
	private String Type	;
	private long Size;
	private String Path;
	private String Time;
	
	public Data1(String Name,String Type,long Size,String Path,String Time) {
		this.Name = Name;
		this.Type = Type;
		this.Size = Size;
		this.Path = Path;
		this.Time = Time;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public long getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	@Override
	public String toString() {
		return "Data [Name=" + Name + ", Type=" + Type + ", Size=" + Size + ", Path=" + Path + ", Time=" + Time + "]";
	}
	
}
