package kshrd.com.kh;

import kshrd.com.kh.wagu.Block;
import kshrd.com.kh.wagu.Board;

/*
 *
 * @author Thedath Oudarya
 */
public class MyTitle {

    //TODO: FOR SHOWING TITLE IN BOX
    public static void show(String name, String address) {
        String blockData = name + "\n" + address;

        Board board = new Board(40);
        Block block = new Block(board, 30, 2, blockData)
                .setBlockAlign(Block.BLOCK_RIGHT)
                .setDataAlign(Block.DATA_CENTER);
        String preview = board.setInitialBlock(block).build().getPreview();
        System.out.println(preview);
    }
    public static void show(String name) {
        String blockData = name;

        Board board = new Board(40);
        Block block = new Block(board, 30, 1, blockData)
                .setBlockAlign(Block.BLOCK_RIGHT)
                .setDataAlign(Block.DATA_CENTER);
        String preview = board.setInitialBlock(block).build().getPreview();
        System.out.println(preview);
    }

}
