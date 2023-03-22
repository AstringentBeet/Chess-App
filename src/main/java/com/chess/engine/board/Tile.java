package com.chess.engine.board;//establishes base tiles for chess board.
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
* suoer-class.
 */

import com.chess.engine.pieces.Piece;

public abstract class Tile
{
    int tileCoordinate;

    //constructor will allow us to create an individual tile.
    Tile(int tileCoordinate) { this.tileCoordinate = tileCoordinate; }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public static final class EmptyTile extends Tile
    {
        //when using super constructors, keep the parameter names consistent.
        EmptyTile(int tileCoordinate) { super(tileCoordinate); }

        @Override
        public boolean isTileOccupied() { return false; }

        @Override
        public Piece getPiece() { return null; }
    }

    public static final class OccupiedTile extends Tile
    {
        Piece pieceOnTile;

        OccupiedTile(int tileCoordinate, Piece pieceOnTile)
        {
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
