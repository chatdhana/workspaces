package mine.algorithms.javaapi;

import java.util.Random;

public class Mobile implements Comparable<Mobile> {

	int modelId;
	String modelName;
	String shortDesc;
	String color;
	float price = new Random().nextFloat();
	String make;
	String YOM;

	public Mobile(int modelId, String modelName) {
		if (modelId == 0 || modelName == null) {
			throw new NullPointerException();
		}
		this.modelId = modelId;
		this.modelName = modelName;
	}

	@Override
	public String toString() {
		return modelId + modelName + "+" + super.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Mobile)) {
			return false;
		}
		Mobile mob = (Mobile) obj;
		return this.modelId == mob.modelId && this.modelName.equals(mob.modelName);
	}

	@Override
	public int hashCode() {
		return modelId + modelName.hashCode();
	}

	@Override
	public int compareTo(Mobile o) {
		int idComp = this.modelId - o.modelId;
		return idComp == 0 ? this.modelName.compareTo(o.modelName) : idComp;
	}

}