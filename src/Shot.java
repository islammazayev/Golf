
public class Shot {
	
	Shot(Double startVelocity, Double startAngle ){
		this.StartAngle = startAngle;
		this.startVelocity = startVelocity;
		this.distance=(double) Math.round(Math.pow(this.startVelocity, 2) / 9.8 * Math.sin(2 * ((Math.PI / 180) * StartAngle)));
	}
	
	
	
	
	Double StartAngle;
	Double startVelocity;
	Double distance;
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}

}
