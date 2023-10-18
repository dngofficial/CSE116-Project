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

    public void traversal(BinaryTreeNode<Song> node) {
        if (node != null) {
            traversal(node.getLeft());
            System.out.print(node.getValue());
            traversal(node.getRight());
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
        if (node == null)
        {
            return null;
        }
        else {
            this.stubValueLinkedListTrue = null;
            getSongListCoreRecursionLoop(node);
            return this.stubValueLinkedListTrue;
        }
    }
    private void getSongListCoreRecursionLoop(BinaryTreeNode<Song> node)
    {
        if (node != null) {
            getSongListCoreRecursionLoop(node.getLeft());
            addSongHelper(node.getValue());
            getSongListCoreRecursionLoop(node.getRight());
        }
    }

    private void addSongHelper(Song song)
    {
        if(this.stubValueLinkedListTrue == null)
        {
            this.stubValueLinkedListTrue = new LinkedListNode<>(song, null);
        }
        else {
            this.stubValueLinkedListTrue.append(song);
        }
    }

    public LinkedListNode<Song> getSongList() {
        return getSongList(this.songBinaryTree);
    }

}
