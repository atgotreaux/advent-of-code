package com.gotreaux.aoc.puzzles.year2022.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class DirectoryTest {
    @Test
    void parent() {
        var root = new Directory("/");
        var child = new Directory("child", root);
        var grandChild = new Directory("grandChild", child);

        assertEquals(root, root.getParent());
        assertEquals(root, child.getParent());
        assertEquals(child, grandChild.getParent());
    }

    @Test
    void root() {
        var root = new Directory("/");
        var child = new Directory("child", root);
        var grandChild = new Directory("grandChild", child);

        assertEquals(root, root.getRoot());
        assertEquals(root, child.getRoot());
        assertEquals(root, grandChild.getRoot());
    }

    @Test
    void directory() {
        var directory = new Directory("directory");
        var x = new Directory("x", directory);
        directory.addDirectory(x);
        var y = new Directory("y", directory);
        directory.addDirectory(y);
        y.addDirectory(new Directory("z", y));

        assertEquals(x, directory.getDirectory("x"));
        assertEquals(y, directory.getDirectory("y"));
        assertThrows(NoSuchElementException.class, () -> directory.getDirectory("z"));
    }

    @Test
    void directories() {
        var directory = new Directory("directory");
        directory.addDirectory(new Directory("x", directory));
        directory.addDirectory(new Directory("y", directory));
        directory.addDirectory(new Directory("z", directory));

        assertEquals(3, directory.getDirectories().size());
    }

    @Test
    void size() {
        var root = new Directory("/");
        root.addFile(new File(14848514, "b.txt"));
        root.addFile(new File(8504156, "c.dat"));

        var dirA = new Directory("a", root);
        dirA.addFile(new File(29116, "f"));
        dirA.addFile(new File(2557, "g"));
        dirA.addFile(new File(62596, "h.lst"));
        root.addDirectory(dirA);

        var dirE = new Directory("e", dirA);
        dirE.addFile(new File(584, "i"));
        dirA.addDirectory(dirE);

        var dirD = new Directory("d", root);
        dirD.addFile(new File(4060174, "j"));
        dirD.addFile(new File(8033020, "d.log"));
        dirD.addFile(new File(5626152, "d.ext"));
        dirD.addFile(new File(7214296, "k"));
        root.addDirectory(dirD);

        assertEquals(48381165, root.size());
        assertEquals(94853, dirA.size());
        assertEquals(24933642, dirD.size());
        assertEquals(584, dirE.size());
    }
}
