# -*- coding: utf-8 -*-
"""
Created on Mon Oct  3 02:10:23 2011

@author: IxxI
@version: v1.0
"""

import sys
import logging
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER
from mcp import getchangedsrc_side


def main():
    parser = OptionParser(version='MCP %s' % Commands.fullversion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    getchangedsrc(options.config)


def getchangedsrc(conffile):
    try:
        commands = Commands(conffile)

        getchangedsrc_side(commands, CLIENT)
        getchangedsrc_side(commands, SERVER)
    except Exception:  # pylint: disable-msg=W0703
        logging.exception('FATAL ERROR')
        sys.exit(1)

if __name__ == '__main__':
    main()
