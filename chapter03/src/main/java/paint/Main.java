package paint;

import com.douzone.paint.shape.Cirecle;
import com.douzone.paint.shape.Rectangle;
import com.douzone.paint.shape.Triangle;

public class Main {

	public static void main(String[] args) {
		
		Point point1 = new Point(0, 0);
//		point1.setX(10);
//		point1.setY(10);
//		
		drawPoint(point1);
	//	point.show(false);

		ColorPoint Point2 = new ColorPoint();
		
		Point2.setX(100);
		Point2.setY(200);
		((ColorPoint)Point2).setColor("red");
		drawPoint(Point2);
		
		Triangle triangle = new Triangle();
		drawTriangle(triangle);
		triangle.draw();
		
		Rectangle rectangle = new Rectangle();
		rectangle.draw();
		
		Cirecle circle = new Cirecle();
		circle.draw();
		
		GraphicText = new GraphicText("hello world");
		draw(text);
		
		//instanceof test
	}
	
	public static void draw(Drawable drawable) {
		
	}
//	public static void drawPoint(Point point) {
//		point.show();
//		
//	}
//	public static void drawRectangle(Rectangle rectangle) {
//		rectangle.draw();
		
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
		
//	}
//	public static void drawCircle(Cirecle cirecle) {
//		cirecle.draw();
		
//	}
	
//	public static void drawColorPoint(ColorPoint colorPoint) {
//		colorPoint.show();
		
		
//	}

}
