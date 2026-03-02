package game2048;

import org.junit.Assert;
import org.junit.Test;

public class TestSingleColumnTilt extends TestUtils {

    @Test
    public void testEmpty() {

        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[after.length];
        model = new Model(before, 0, 0, false);
        String prevBoard = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after, 0, 0, prevBoard, Side.NORTH);
    }

    @Test
    public void testOneTile() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);
    }

    @Test
    public void testTwoTileNotEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);

        int[][] before5 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
        };

        model = new Model(before5, 0, 0, false);
        String prevBoard5 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard5, Side.NORTH);

        int[][] before6 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };

        model = new Model(before6, 0, 0, false);
        String prevBoard6 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard6, Side.NORTH);
    }

    @Test
    public void testTwoTileEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);

        int[][] before5 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before5, 0, 0, false);
        String prevBoard5 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard5, Side.NORTH);

        int[][] before6 = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before6, 0, 0, false);
        String prevBoard6 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard6, Side.NORTH);
    }


    @Test
    public void testTreeTileEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);
    }

    @Test
    public void testTwoTileEqualsNotOne() {
        int[][] before1 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);


        int[][] before5 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after5 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before5, 0, 0, false);
        String prevBoard5 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after5, 0, 0, prevBoard5, Side.NORTH);

        int[][] before6 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before6, 0, 0, false);
        String prevBoard6 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after5, 0, 0, prevBoard6, Side.NORTH);

        int[][] before7 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
        };


        model = new Model(before7, 0, 0, false);
        String prevBoard7 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after5, 0, 0, prevBoard7, Side.NORTH);

        int[][] before8 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before8, 0, 0, false);
        String prevBoard8 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after5, 0, 0, prevBoard8, Side.NORTH);


        int[][] before9 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after9 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before9, 0, 0, false);
        String prevBoard9 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after9, 0, 0, prevBoard9, Side.NORTH);

        int[][] before10 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
        };


        model = new Model(before10, 0, 0, false);
        String prevBoard10 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after9, 0, 0, prevBoard10, Side.NORTH);

        int[][] before11 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };


        model = new Model(before11, 0, 0, false);
        String prevBoard11 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after9, 0, 0, prevBoard11, Side.NORTH);

        int[][] before12 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };

        model = new Model(before12, 0, 0, false);
        String prevBoard12 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after9, 0, 0, prevBoard12, Side.NORTH);
    }


    @Test
    public void testTreeTileNotEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {8, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
        };


        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
        };

        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard4, Side.NORTH);
    }

    @Test
    public void testForeTileEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(8, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);
    }

    @Test
    public void testForeTileNotEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {16, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {16, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);
    }

    @Test
    public void testForeTileOnlyTwoEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {8, 0, 0, 0},
        };
        int[][] after2 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {8, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after2, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after3 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {2, 0, 0, 0},
        };

        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after3, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {8, 0, 0, 0},
        };
        int[][] after4 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {0, 0, 0, 0},
        };
        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after4, 0, 0, prevBoard4, Side.NORTH);

        int[][] before5 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {8, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after5 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {8, 0, 0, 0},
                {2, 0, 0, 0},
        };
        model = new Model(before5, 0, 0, false);
        String prevBoard5 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(0, result.score);
        checkModel(after5, 0, 0, prevBoard5, Side.NORTH);

        int[][] before6 = new int[][]{
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after6 = new int[][]{
                {4, 0, 0, 0},
                {8, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };
        model = new Model(before6, 0, 0, false);
        String prevBoard6 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after6, 0, 0, prevBoard6, Side.NORTH);
    }

    @Test
    public void testForeTileOnlyTreeEquals() {
        int[][] before1 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };
        int[][] after1 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };
        boolean[] changedArr = new boolean[4];
        model = new Model(before1, 0, 0, false);
        String prevBoard1 = model.toString();
        Model.Result result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after1, 0, 0, prevBoard1, Side.NORTH);

        int[][] before2 = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
        };

        int[][] after2 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before2, 0, 0, false);
        String prevBoard2 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after2, 0, 0, prevBoard2, Side.NORTH);

        int[][] before3 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after3 = new int[][]{
                {2, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
        };

        model = new Model(before3, 0, 0, false);
        String prevBoard3 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after3, 0, 0, prevBoard3, Side.NORTH);

        int[][] before4 = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after4 = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        model = new Model(before4, 0, 0, false);
        String prevBoard4 = model.toString();
        result = model.singleColumnTilt(0);
        Assert.assertEquals(4, result.score);
        checkModel(after4, 0, 0, prevBoard4, Side.NORTH);
    }


}
