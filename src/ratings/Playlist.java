package ratings;

import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.BinaryTreeNode;
import ratings.Song;

public class Playlist {
    private String title;

    private BinaryTreeNode<Song> songBinaryTree = null;

    private LinkedListNode<Song> stubValueLinkedListTrue = null;
    private Comparator<Song> comparator = null;
    public Playlist(Comparator<Song> comparator) {
        this.comparator = comparator;
    }

    public BinaryTreeNode<Song> getSongTree() {
        return this.songBinaryTree;
    }

    public void setTitle(String title){this.title = title;}

    public void addSong(Song song) {
        if (this.songBinaryTree == null) {
            this.songBinaryTree = new BinaryTreeNode<Song>(song, null, null);
        } else {
            this.insertHelper(this.songBinaryTree, song);
        }
    }
    private void insertHelper(BinaryTreeNode<Song> node, Song songToInsert) {
        if (this.comparator.compare(songToInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<Song>(songToInsert, null, null));
            } else {
                insertHelper(node.getLeft(), songToInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<Song>(songToInsert, null, null));
            } else {
                insertHelper(node.getRight(), songToInsert);
            }
        }
    }

    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> node) {
        this.stubValueLinkedListTrue = null;
        getSongListCoreRecursionLoop(node);
        return this.stubValueLinkedListTrue;
    }
    private void getSongListCoreRecursionLoop(BinaryTreeNode<Song> node)
    {
        if (node != null) {
            getSongListCoreRecursionLoop(node.getLeft());
            this.stubValueLinkedListTrue.append(node.getValue());
            getSongListCoreRecursionLoop(node.getRight());
        }
    }

    public LinkedListNode<Song> getSongList() {
        return getSongList(this.songBinaryTree);
    }

}
