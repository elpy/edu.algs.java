public final class Connection{
	private int p, q;
		
	public Connection(int p, int q){
		this.p = p;
		this.q = q;
	}
	
	public int GetQ(){
		return q;
	}

	public int GetP(){
		return p;
	}
	
	@Override
	public String toString(){
		return String.format("pair: p=%d q=%d", p, q);
	}		
}