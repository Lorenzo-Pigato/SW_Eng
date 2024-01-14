package exams.e2020_01_14.exercise_3;

public interface Tool {
    void click();
}

class Pencil implements Tool{
    @Override
    public void click() {
        System.out.println("Using pencil");
    }
}

class Eraser implements Tool{
    @Override
    public void click() {
        System.out.println("Using eraser");
    }
}

class Brush implements Tool{
    @Override
    public void click() {
        System.out.println("Using brush");
    }
}

class Mouse{
    private Tool tool;
    
    private void setTool(String tool){
        if(tool.equalsIgnoreCase("pencil")) this.tool = new Pencil();
        if(tool.equalsIgnoreCase("brush")) this.tool = new Brush();
        if(tool.equalsIgnoreCase("eraser")) this.tool = new Eraser();
        
    }

    private void click(){
        tool.click();
    }

    public static void main(String[] args) {
        Mouse myMouse = new Mouse();
        myMouse.setTool("pencil");
        myMouse.click();
    }
}