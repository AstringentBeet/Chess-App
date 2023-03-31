package com.chess.engine.board;

//establishes base tiles for chess board.
//this file shows nested classes in use.

/*
 * Quick note on static nested classes: Because
 * the static method subclasses (EmptyTile, OccupiedTile)
 * are an extension of the com.chess.engine.board.Tile class, they are able to
 * override the abstract methods, creating their own
 * implementation and behavior.
 */

//only methods can be overridden

/*
* When extending an interface or abstract class, you
* are basically making a contract of sorts with the respective
* super-class.
 */

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    // This constructor will allow us to create an individual tile.
    private Tile(int tileCoordinate) { this.tileCoordinate = tileCoordinate; }
    protected final int tileCoordinate;
    public abstract boolean isTileOccupied();
    public abstract Piece getPiece();
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        //every possible that could exist is created upfront.
        for(int i = 0; i < 64; i++) {emptyTileMap.put(i, new EmptyTile(i));}

        //using google's guava library, ImmutableMap - as the name implies – makes the map immutable.
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece)
                : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    public static final class EmptyTile extends Tile {
        //when using super constructors, keep the parameter names consistent.
        private EmptyTile(final int tileCoordinate) { super(tileCoordinate); }

        @Override
        public boolean isTileOccupied() { return false; }

        @Override
        public Piece getPiece() { return null; }
    }

    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
            //implements tile coordinates (a1-h8).
            super(tileCoordinate);
            //details the specific piece (pawn, bishop, etc.) on the tile.
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied() { return true; }

        @Override
        public Piece getPiece() { return this.pieceOnTile; }
    }
}
