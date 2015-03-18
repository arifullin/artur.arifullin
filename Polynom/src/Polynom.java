public class Polynom{
	private double[] koff;
	public Polynom(double[] x){
		int a = 0;
		koff = new double[x.length];
		for (double i : x) {
			
			koff[a] = i;
			a++;
		}
	}
	public void add(Polynom x){
		double[] polinom1 = new double[koff.length];
		double[] polinom2;
		int count = 0;
		for (int i = 0;i < koff.length ;i++ ) {
				polinom1[i] = koff[i];
			}
		polinom2 = x.get();
		if (polinom1.length < polinom2.length) {
			polinom1 = new double[polinom2.length];
			for (int i = 0;i < koff.length ;i++ ) {
				polinom1[i] = koff[i];
			}
			koff = new double[polinom2.length];
		}else if (polinom1.length > polinom2.length) {
			double[] polinomTemp = new double[polinom2.length];
			for (int i = 0;i < polinom2.length;i++ ) {
					polinomTemp[i] = polinom2[i];		
				}	
			polinom2 = new double[polinom1.length];
			for (int i = 0;i < polinomTemp.length;i++ ) {
					polinom2[i] = polinomTemp[i];		
				}	
				koff = new double[polinom1.length];
		}
		for (int i = 0;i < polinom2.length;i++ ) {
			koff[i] = polinom1[i]+polinom2[i];
		}
		double[] polinomTemp = new double[koff.length];
		for (int i = 0;i < koff.length;i++ ) {
			polinomTemp[i] = koff[i];
		}

		for (int i = koff.length-1;i>0 ;i-- ) {
			if (koff[i]!=0) {
				count = i;
				break;
			}
		}
		koff = new double[count+1];
		for (int i = 0;i<=count ;i++ ) {
			koff[i] = polinomTemp[i];
		}
				
	}
	public void multiply(Polynom x){
		double[] polinom1 = new double[koff.length];		
		double[] polinom2 = x.get();
		for (int i = 0;i<koff.length ;i++ ) {
			polinom1[i] = koff[i];
		}
		koff = new double[polinom1.length + polinom2.length - 1];
		for (int i = 0;i<polinom1.length ;i++ ) {
			for (int j = 0;j<polinom2.length ;j++ ) {
				koff[i+j] += polinom1[i]*polinom2[j];
			}
		}

	}
	public void minus(Polynom x){
		double[] polinom1 = new double[koff.length];
		double[] polinom2;
		int count = 0;
		for (int i = 0;i < koff.length ;i++ ) {
				polinom1[i] = koff[i];
			}
		polinom2 = x.get();
		if (polinom1.length < polinom2.length) {
			polinom1 = new double[polinom2.length];
			for (int i = 0;i < koff.length ;i++ ) {
				polinom1[i] = koff[i];
			}
			koff = new double[polinom2.length];
		}else if (polinom1.length > polinom2.length) {
			double[] polinomTemp = new double[polinom2.length];
			for (int i = 0;i < polinom2.length;i++ ) {
					polinomTemp[i] = polinom2[i];		
				}	
			polinom2 = new double[polinom1.length];
			for (int i = 0;i < polinomTemp.length;i++ ) {
					polinom2[i] = polinomTemp[i];		
				}	
				koff = new double[polinom1.length];
		}
		for (int i = 0;i < polinom2.length;i++ ) {
			koff[i] = polinom1[i]-polinom2[i];
		}
		double[] polinomTemp = new double[koff.length];
		for (int i = 0;i < koff.length;i++ ) {
			polinomTemp[i] = koff[i];
		}

		for (int i = koff.length-1;i>0 ;i-- ) {
			if (koff[i]!=0) {
				count = i;
				break;
			}
		}
		koff = new double[count+1];
		for (int i = 0;i<=count ;i++ ) {
			koff[i] = polinomTemp[i];
		}
	}
	public StringBuilder toStr(){
		StringBuilder polynom = new StringBuilder();
		polynom.append("("+koff[0]+")+");
		for (int i = 1;i<koff.length ;i++ ) {
			if (koff[i] == 0) {
				continue;
			}
			polynom.append("("+koff[i]+")"+"x^"+i+"+");
		}
		polynom.deleteCharAt(polynom.length()-1);
		return polynom;
	}
	public double[] get(){
		return koff;
	}

}