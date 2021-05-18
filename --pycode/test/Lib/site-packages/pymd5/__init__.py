#! /usr/bin/env python
"""Recursively calculate and display MD5 file hashes.

Hashes are calculated for all files rooted in the given directory. Hashes
and file paths (relative to given directory) are output to stdout, problem
files reported on stderr. File paths are output in alphabetical order, and
don't include the name of the top-level directory.

Output matches that of md5sum(1): "{md5-hash} *{relative file path}", e.g:

    7df5132659452a47ec54aa7158995e21 *pymd5.py
"""
from __future__ import print_function

import argparse
import os
import sys
import hashlib

CHUNK_SIZE = 1024*1024

def _hash_file(filepath):
    """Calculate MD5 hash of the contents of a single file."""

    digest = hashlib.md5()

    with open(filepath, 'rb') as handle:
        chunk = handle.read(CHUNK_SIZE)
        while chunk:
            digest.update(chunk)
            chunk = handle.read(CHUNK_SIZE)
    return digest.hexdigest()


def calculate_hashes(dirpath):
    """Calculate MD5 hashes for all files rooted in `dirpath`."""
    length = len(dirpath) + 1

    for root, dirs, files in os.walk(dirpath):
        dirs.sort()
        files.sort()
        for file_ in files:
            filepath = os.path.join(root, file_)
            relpath = filepath[length:]
            try:
                digest = _hash_file(filepath)
                sys.stdout.write('%s *%s\n' % (digest, relpath))
                sys.stdout.flush()
            except IOError:
                sys.stderr.write("Error reading file: '%s'\n" % filepath)
                sys.stdout.flush()

def _read_args():
    """Retrieve and validate command-line arguments."""

    def validate_dir(dirname):
        """Check dirname is valid directory, raise ArgumentTypeError if not."""
        dirpath = os.path.abspath(dirname)
        if not os.path.isdir(dirpath):
            msg = "Missing/invalid directory: '%s'" % dirpath
            raise argparse.ArgumentTypeError(msg)
        return dirpath

    parser = argparse.ArgumentParser(
        formatter_class=argparse.RawDescriptionHelpFormatter,
        description=__doc__)

    parser.add_argument('DIRPATH',
                        type=validate_dir,
                        help="Hash all files rooted in this directory.")

    args = parser.parse_args()
    calculate_hashes(args.DIRPATH)
