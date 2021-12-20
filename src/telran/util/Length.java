package telran.util;

public class Length implements Comparable<Length> {
	public float amount;
	public LengthUnit unit;
	private final static float epsilon = 0.00001f;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}
	
	@Override
	/**
	 * equals two Length objects according to LengthUnit
	 * 10m == 10000mm
	 */
	public boolean equals(Object obj) {
		//TODO
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Length other = (Length) obj;
		if(other.unit != unit) {
			other = other.convert(unit);
		}
		return Math.abs(amount-other.amount)<epsilon;
		// Done
	}

	@Override
	public int compareTo(Length o) {
		// TODO Auto-generated method stub
		Length obj = o;
		if(unit!=o.unit) {
			obj = obj.convert(unit);
		}
		if(Math.abs(amount-obj.amount)<epsilon) {
			return 0;
		}
		return Float.compare(amount, obj.amount);
		//	Done
	}
	/**
	 * 
	 * @param unit
	 * @return new Length object with a given LengthUnit
	 * convert(LengthUnit.M) returns Length in meters 
	 */
	public Length convert(LengthUnit otherUnit) {
		//TODO
		float factor = (this.unit).getValue()/otherUnit.getValue();
		return new Length(amount*factor, otherUnit);
		//	Done
	}
	@Override
	/**
	 * returns string with amount and length unit pinned to amount with no space
	 * Example: 20M (string expression of Length object designed 20 meters)
	 */
	public String toString() {
		//TODO
		return String.format("%.4f", amount) + unit.toString();
//		return "";
		// Done
	}
	
	public static float getPrecision() {
		return epsilon;
	}
	
	

}
