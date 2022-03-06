/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flooring.UI;

/**
 *
 * @author mariana.bonish
 */
public class FlooringView {
    private UserIO io;
    public FlooringView(UserIO io){
        this.io = io;
    }
    public void menu(){
        io.print(
" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n" +
"   * <<Flooring Program>>\n" +
"   * 1. Display Orders\n" +
"   * 2. Add an Order\n" +
"   * 3. Edit an Order\n" +
"   * 4. Remove an Order\n" +
"   * 5. Export All Data\n" +
"   * 6. Quit\n" +
"   *\n" +
"   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        
    }
    
    public int MenuSelection(){
        return io.readInt("Please select option 1-6");
    }
    
}
