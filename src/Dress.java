

public class Dress {
	

		private String fabric;
		private String color;
		private double price;
		private boolean available;
		private String category;
		private String size;
		
		public Dress(String fabric,String color,double price,boolean available,String category,String size)
		{
			this.fabric=fabric;
			this.color=color;
			this.price=price;
			this.available=available;
			this.category=category;
			this.size=size;
		}

		public String getFabric() {
			return fabric;
		}

		public void setFabric(String fabric) {
			this.fabric = fabric;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}
		
		
		
		
	}


