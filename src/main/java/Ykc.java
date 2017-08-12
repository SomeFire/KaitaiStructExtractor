// This is a generated file! Please edit source .ksy file and use kaitai-struct-compiler to rebuild

import io.kaitai.struct.KaitaiStream;
import io.kaitai.struct.KaitaiStruct;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Ykc extends KaitaiStruct {
    public static Ykc fromFile(String fileName) throws IOException {
        return new Ykc(new KaitaiStream(fileName));
    }

    public Ykc(KaitaiStream _io) {
        super(_io);
        this._root = this;
        _read();
    }

    public Ykc(KaitaiStream _io, KaitaiStruct _parent) {
        super(_io);
        this._parent = _parent;
        this._root = this;
        _read();
    }

    public Ykc(KaitaiStream _io, KaitaiStruct _parent, Ykc _root) {
        super(_io);
        this._parent = _parent;
        this._root = _root;
        _read();
    }
    private void _read() {
        this.magic = this._io.ensureFixedContents(new byte[] { 89, 75, 67, 48, 48, 49, 0, 0 });
        this.magic2 = this._io.ensureFixedContents(new byte[] { 24, 0, 0, 0, 0, 0, 0, 0 });
        this.headerOfs = this._io.readU4le();
        this.headerLen = this._io.readU4le();
    }
    public static class Header extends KaitaiStruct {
        public static Header fromFile(String fileName) throws IOException {
            return new Header(new KaitaiStream(fileName));
        }

        public Header(KaitaiStream _io) {
            super(_io);
            _read();
        }

        public Header(KaitaiStream _io, Ykc _parent) {
            super(_io);
            this._parent = _parent;
            _read();
        }

        public Header(KaitaiStream _io, Ykc _parent, Ykc _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.entries = new ArrayList<FileEntry>();
            while (!this._io.isEof()) {
                this.entries.add(new FileEntry(this._io, this, _root));
            }
        }
        private ArrayList<FileEntry> entries;
        private Ykc _root;
        private Ykc _parent;
        public ArrayList<FileEntry> entries() { return entries; }
        public Ykc _root() { return _root; }
        public Ykc _parent() { return _parent; }
    }
    public static class FileEntry extends KaitaiStruct {
        public static FileEntry fromFile(String fileName) throws IOException {
            return new FileEntry(new KaitaiStream(fileName));
        }

        public FileEntry(KaitaiStream _io) {
            super(_io);
            _read();
        }

        public FileEntry(KaitaiStream _io, Header _parent) {
            super(_io);
            this._parent = _parent;
            _read();
        }

        public FileEntry(KaitaiStream _io, Header _parent, Ykc _root) {
            super(_io);
            this._parent = _parent;
            this._root = _root;
            _read();
        }
        private void _read() {
            this.filenameOfs = this._io.readU4le();
            this.filenameLen = this._io.readU4le();
            this.bodyOfs = this._io.readU4le();
            this.bodyLen = this._io.readU4le();
            this.unknown5 = this._io.readU4le();
        }
        private String filename;
        public String filename() {
            if (this.filename != null)
                return this.filename;
            KaitaiStream io = _root._io();
            long _pos = io.pos();
            io.seek(filenameOfs());
            this.filename = new String(io.readBytes(filenameLen()), Charset.forName("SJIS"));
            io.seek(_pos);
            return this.filename;
        }
        private byte[] body;
        public byte[] body() {
            if (this.body != null)
                return this.body;
            KaitaiStream io = _root._io();
            long _pos = io.pos();
            io.seek(bodyOfs());
            this.body = io.readBytes(bodyLen());
            io.seek(_pos);
            return this.body;
        }
        private long filenameOfs;
        private long filenameLen;
        private long bodyOfs;
        private long bodyLen;
        private long unknown5;
        private Ykc _root;
        private Ykc.Header _parent;
        public long filenameOfs() { return filenameOfs; }
        public long filenameLen() { return filenameLen; }
        public long bodyOfs() { return bodyOfs; }
        public long bodyLen() { return bodyLen; }
        public long unknown5() { return unknown5; }
        public Ykc _root() { return _root; }
        public Ykc.Header _parent() { return _parent; }
    }
    private Header header;
    public Header header() {
        if (this.header != null)
            return this.header;
        long _pos = this._io.pos();
        this._io.seek(headerOfs());
        this._raw_header = this._io.readBytes(headerLen());
        KaitaiStream _io__raw_header = new KaitaiStream(_raw_header);
        this.header = new Header(_io__raw_header, this, _root);
        this._io.seek(_pos);
        return this.header;
    }
    private byte[] magic;
    private byte[] magic2;
    private long headerOfs;
    private long headerLen;
    private Ykc _root;
    private KaitaiStruct _parent;
    private byte[] _raw_header;
    public byte[] magic() { return magic; }
    public byte[] magic2() { return magic2; }
    public long headerOfs() { return headerOfs; }
    public long headerLen() { return headerLen; }
    public Ykc _root() { return _root; }
    public KaitaiStruct _parent() { return _parent; }
    public byte[] _raw_header() { return _raw_header; }
}
