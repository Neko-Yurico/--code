# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2020.3.2\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/ex02_2.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/ex02_2.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/ex02_2.dir/flags.make

CMakeFiles/ex02_2.dir/main.cpp.obj: CMakeFiles/ex02_2.dir/flags.make
CMakeFiles/ex02_2.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/ex02_2.dir/main.cpp.obj"
	D:\Environment\mingw64\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\ex02_2.dir\main.cpp.obj -c D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\main.cpp

CMakeFiles/ex02_2.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/ex02_2.dir/main.cpp.i"
	D:\Environment\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\main.cpp > CMakeFiles\ex02_2.dir\main.cpp.i

CMakeFiles/ex02_2.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/ex02_2.dir/main.cpp.s"
	D:\Environment\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\main.cpp -o CMakeFiles\ex02_2.dir\main.cpp.s

# Object files for target ex02_2
ex02_2_OBJECTS = \
"CMakeFiles/ex02_2.dir/main.cpp.obj"

# External object files for target ex02_2
ex02_2_EXTERNAL_OBJECTS =

ex02_2.exe: CMakeFiles/ex02_2.dir/main.cpp.obj
ex02_2.exe: CMakeFiles/ex02_2.dir/build.make
ex02_2.exe: CMakeFiles/ex02_2.dir/linklibs.rsp
ex02_2.exe: CMakeFiles/ex02_2.dir/objects1.rsp
ex02_2.exe: CMakeFiles/ex02_2.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ex02_2.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\ex02_2.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/ex02_2.dir/build: ex02_2.exe

.PHONY : CMakeFiles/ex02_2.dir/build

CMakeFiles/ex02_2.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\ex02_2.dir\cmake_clean.cmake
.PHONY : CMakeFiles/ex02_2.dir/clean

CMakeFiles/ex02_2.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2 D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2 D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug D:\Neko-Yurico.github.io\--code\--cppcode\ex02-2\cmake-build-debug\CMakeFiles\ex02_2.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/ex02_2.dir/depend

